const url = `${window.location.origin}/api/v1/public/registrarse`;

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

    return data;
}