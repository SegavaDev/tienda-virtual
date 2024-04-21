const url = "http://127.0.0.1:3001/api/v1/registrarse";

export async function apiRegistro(registro) {
    const req = await fetch(url, {
        method: "post",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(registro),
    });

    const res = await req.json();
    const data = res;

    console.log(data);
}