export async function getAllField()
    {
        const response = await fetch(`http://localhost:8080/simplyField/webresources/field/allFields/`);
        if (response.ok === true) {
            return response.json();
        }

        throw new Error('Impossible de contacter le serveur');        
    }

export async function getSingleField(id)
    {
        const response = await fetch(`http://localhost:8080/simplyField/webresources/field/singleField/${id}`);
        if (response.ok === true) {
            return response.json();
        }

        throw new Error('Impossible de contacter le serveur');
    }