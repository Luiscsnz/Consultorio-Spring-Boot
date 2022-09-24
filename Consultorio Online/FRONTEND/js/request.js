//const url = "https://minticloud.uis.edu.co/c3s20grupo14"
const url = "http://localhost:8080/"
    //

function sendRequest(endpoint, method, data) {
    let request = new XMLHttpRequest();

    console.log(url + endpoint)
    request.open(method, url + endpoint);
    request.setRequestHeader('Content-Type', 'application/json');
    request.setRequestHeader('Access-Control-Allow-Origin', '*');
    request.setRequestHeader("Access-Control-Allow-Credentials", "true");
    request.setRequestHeader("Access-Control-Allow-Methods", "GET,HEAD,OPTIONS,POST,PUT");
    request.setRequestHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
    request.responseType = 'json';
    request.send(data ? JSON.stringify(data) : data);
    return request
}