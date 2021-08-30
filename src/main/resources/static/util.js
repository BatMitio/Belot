let host = 'http://91.139.199.150:8080';

async function request(url, options){
    try{
        let response = await fetch(url, options);
        if(!response.ok){
            const error = await response.json();
            throw new Error(error.message);
        }

        try{
            const data = await response.json();
            return data;
        }
        catch (err){
            return response;
        }
    }
    catch (err){
        alert(err.message)
        throw err;
    }
}

function getOptions(method = 'GET', body){
    const options = {
        method,
        headers: {}
    }

    let token = localStorage.getItem("token");
    let username = localStorage.getItem("username");
    if(token){
        options.headers['X-Authorization'] = token;
        options.headers['username'] = username;
    }

    if(body){
        options.headers['Content-Type'] = 'application/json';
        options.body = JSON.stringify(body);
    }
    return options;
}

export async function get(path){
    return await request(host + path, getOptions());
}

export async function post(path, data){
    return await request(host + path, getOptions("POST", data))
}

export async function login(username, password) {
    let response = await post('/login', {
        username,
        password
    });

    console.log(response);

    localStorage.setItem("token", response.data.token);
    localStorage.setItem("username", response.data.username);

    return response;
}

export async function register(username, password){
    let response = await post('/register', {
        username,
        password
    });

    console.log(response);

    localStorage.setItem("token", response.data.token);
    localStorage.setItem("username", response.data.username);

    return response;
}

export async function logout(){
    const response = await get('/logout');

    localStorage.clear();

    return response;
}

export async function validCredentials(){
    if(localStorage.getItem("token") != null){
        let response = await get('/validate_credentials');
        console.log(response);

        if(response.message == "Valid credentials!"){
            return true;
        }
    }
    return false;
}