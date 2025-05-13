export async function getAllField()
    {
        const response = await fetch(`http://localhost:8080/simplyField/webresources/field/allFields/`, {
            method: 'GET', 
            headers: {
                'Content-Type': 'application/json',
                'Authorization': document.cookie.slice(document.cookie.indexOf('JWT=') + 4),
            }
        });
        if (response.ok === true) {
            return response.json();
        }

        throw new Error('Impossible de contacter le serveur');        
    }

export async function getSingleField(id)
    {
        const response = await fetch(`http://localhost:8080/simplyField/webresources/field/singleField/${id}`, {
            method: 'GET', 
            headers: {
                'Content-Type': 'application/json',
                'Authorization': document.cookie.slice(document.cookie.indexOf('JWT=') + 4),
            }
        });
        if (response.ok === true) {
            return response.json();
        }

        throw new Error('Impossible de contacter le serveur');
    }

export async function deleteFieldById(id)
    {
        const response = fetch(`http://localhost:8080/simplyField/webresources/field/deleteField/${id}`, {
            method: 'DELETE', 
            headers: {
                'Content-Type': 'application/json',
                'Authorization': document.cookie.slice(document.cookie.indexOf('JWT=') + 4),
            }
        });
    }

    