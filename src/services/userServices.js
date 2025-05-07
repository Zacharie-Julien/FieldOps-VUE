

export async function getAllUsers()
    {
        const response = await fetch(`http://localhost:8080/simplyField/webresources/users/allUsers/`);
        if (response.ok === true) {
            return await response.json();    
        }
        throw new Error('Impossible de contacter le serveur');        
    }
    
export async function getUserById(id)
    {
        const response = await fetch(`http://localhost:8080/simplyField/webresources/users/singleUser/${id}`);
        if (response.ok === true) {
            return response.json();    
        }
        throw new Error('Impossible de contacter le serveur');        
    }


export async function getAllOwners()
    {
        const response = await fetch(`http://localhost:8080/simplyField/webresources/users/allOwners/`);
        if (response.ok === true) {
            return response.json();    
        }
        throw new Error('Impossible de contacter le serveur');        
    }

export default async function getSingleOwner(id)
    {
        const response = await fetch(`http://localhost:8080/simplyField/webresources/users/singleOwner/${id}`);
        if (response.ok === true) {
            return response.json();    
        }
        throw new Error('Impossible de contacter le serveur');        
    }



export async function getSingleWorkers(id)
    {
        const response = await fetch(`http://localhost:8080/simplyField/webresources/users/singleWorker/${id}`);
        if (response.ok === true) {
            return response.json();    
        }
        throw new Error('Impossible de contacter le serveur');        
    }    

export async function getAllWorkers()
    {
        const response = await fetch(`http://localhost:8080/simplyField/webresources/users/allWorkers/`);
        if (response.ok === true) {
            return response.json();    
        }
        throw new Error('Impossible de contacter le serveur');        
    }    