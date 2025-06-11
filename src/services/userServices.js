

export async function getAllUsers()
    {
        const response = await fetch(`http://localhost:8080/simplyField/webresources/users/allUsers/`, {
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
    
export async function getUserById(id)
    {
        const response = await fetch(`http://localhost:8080/simplyField/webresources/users/singleUser/${id}`, {
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


export async function getAllOwners()
    {
        const response = await fetch(`http://localhost:8080/simplyField/webresources/users/allOwners/`, {
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

export default async function getSingleOwner(id)
    {
        const response = await fetch(`http://localhost:8080/simplyField/webresources/users/singleOwner/${id}`, {
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



export async function getSingleWorkers(id)
    {
        const response = await fetch(`http://localhost:8080/simplyField/webresources/users/singleWorker/${id}`, {
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

export async function getAllWorkers(id)
    {
        const response = await fetch(`http://localhost:8080/simplyField/webresources/domain/singleDomain/${id}`, {
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

export async function getAllPossibleWorkers()
    {
        const response = await fetch(`http://localhost:8080/simplyField/webresources/users/allWorkers`, {
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


export async function deleteWorkerByFromDomain(idWorker, idDomain)
    {
        const response = await fetch(`http://localhost:8080/simplyField/webresources/domain/deleteWorker/${idWorker}/${idDomain}`, {
            method : 'DELETE',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': document.cookie.slice(document.cookie.indexOf('JWT=') + 4),
            }
        });

        if (response.ok) {
            return response;
        }

        throw new Error('Impossible de contacter le serveur');    
    }

export async function addWorkerById(id, domain_id) {
    const response = await fetch(`http://localhost:8080/simplyField/webresources/users/addWorker/${id}/${domain_id}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': document.cookie.slice(document.cookie.indexOf('JWT=') + 4),
        }
    });

    if (response.ok) {
        return response;
    }

    throw new Error('Impossible de contacter le serveur');    
}