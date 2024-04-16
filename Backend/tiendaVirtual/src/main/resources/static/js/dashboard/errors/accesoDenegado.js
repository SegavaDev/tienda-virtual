async function errorAcceso() {
    const url = "http://localhost:3001/dashboard.html";

    const request = await fetch(url);
    const response = await request.status();
    const data = response;
    console.log(data);
}