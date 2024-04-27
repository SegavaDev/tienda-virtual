const url = `${window.location.origin}/authenticate`;

export async function apiLogin(data) {
    try {
        const req = await fetch(url, {
            method: "POST",
            credentials: "include",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(data),
        })
        
        if(req.ok) {
            console.log(req);
            const fetc = await fetch("/dashboard");
            window.location.href = fetc.url;
        }
        else if(req.status == "401") {
            window.location.href = "/error/401.html";
        }
        else if(req.status == "403") {
            window.location.href = "/error/403.html";
        }
        else if(req.status == "404") {
            window.location.href = "/error/403.html";
        }
        else if(req.status == "500") {
            window.location.href = "/error/500.html";
        }

        console.log(req);
    
    } catch (error) {
        console.log(error);
        console.log(url);
    }
}