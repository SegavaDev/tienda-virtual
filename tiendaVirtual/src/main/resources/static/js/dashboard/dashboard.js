// logout
document.querySelector("button").addEventListener(
    "click", async (e) => {
        const logout = await fetch("/logout");
        try {
            if(logout.ok) {
                window.location.href = logout.url;
            }
            
        } catch (error) {
            console.log(error);
        }
    }
)