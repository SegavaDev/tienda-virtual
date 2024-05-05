const url = `${window.location.origin}/api/v1/public/validar/`;

export async function apiValidarDataUser(data, tipo) {
    const req = await fetch(url + tipo, {
        method: "post",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    });

    const res = await req.json();
    return res;
}