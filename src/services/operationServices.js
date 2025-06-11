export async function getAllOperationById(listId) {
    const fieldList = [];    
    const ids = Array.isArray(listId) ? listId : [listId];

    for (const element of ids) {
        
        try {
            const response = await fetch(`http://localhost:8080/simplyField/webresources/operation/allOperationById/${element}`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': document.cookie.slice(document.cookie.indexOf('JWT=') + 4),
                }
            });

            if (!response.ok) {
                throw new Error(`HTTP ${response.status}`);
            }

            const data = await response.json();
            fieldList.push(data);

        } catch (error) {
            alert("Erreur lors de la récupération des opérations pour l'ID " + element + " : " + error.message);
            // Optionnel : continue ou re-throw selon ton besoin
        }
    }

    return fieldList;
}

export async function getAllOperationByWorkerId(id) {
    try {
        const response = await fetch(`http://localhost:8080/simplyField/webresources/operation/allOperationByWorkerId/${id}`, {
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
    } catch (error) {
        alert("Erreur lors de la récupération des opérations d’un ouvrier : " + error.message);
        throw error;
    }
}

export async function addOperation(id_traitement, id_champ, id_ouvrier, dateNow) {
    try {
        const response = await fetch(`http://localhost:8080/simplyField/webresources/operation/addOperation/${id_traitement}/${id_champ}/${id_ouvrier}/true/${dateNow}` + ' 0:0:0', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': document.cookie.slice(document.cookie.indexOf('JWT=') + 4),
            }
        });

        if (response.ok === true) {
            return response;
        }

        throw new Error('Impossible de contacter le serveur');
    } catch (error) {
        alert("Erreur lors de l’ajout de l’opération : " + error.message);
        throw error;
    }
}   

export async function deleteOperation(subitPk) {
    const { id_traitement, id_champ, id_ouvrier, dateNow } = subitPk;

    const dateOnly = dateNow.substring(0, 10); 

    const date = new Date(dateOnly);

    date.setDate(date.getDate() + 1);

    const formattedDate = `${date.getFullYear()}-${(date.getMonth() + 1)
        .toString()
        .padStart(2, '0')}-${date.getDate()
        .toString()
        .padStart(2, '0')}`;

    const url = `http://localhost:8080/simplyField/webresources/operation/deleteSubit/${id_traitement}/${id_champ}/${id_ouvrier}/${formattedDate} 00:00:00`;

    try {
        const response = await fetch(url, {
            method: 'DELETE',
            headers: {
                'Authorization': document.cookie.slice(document.cookie.indexOf('JWT=') + 4)
            }
        });

        if (!response.ok) {
            throw new Error('Erreur lors de la suppression');
        }

        alert("Suppression réussie !");
    } catch (error) {
        alert("Erreur : " + error.message);
    }
}

export async function valideOperation(subitPk) {
    const { id_traitement, id_champ, id_ouvrier, dateNow } = subitPk;

    const dateOnly = dateNow.substring(0, 10); 

    const date = new Date(dateOnly);

    date.setDate(date.getDate() + 1);

    const formattedDate = `${date.getFullYear()}-${(date.getMonth() + 1)
        .toString()
        .padStart(2, '0')}-${date.getDate()
        .toString()
        .padStart(2, '0')}`;

    try {
        const response = await fetch(`http://localhost:8080/simplyField/webresources/operation/valideOperation/${id_traitement}/${id_champ}/${id_ouvrier}/${formattedDate} 00:00:00`, {
            method: 'POST',
            headers: {
                'Authorization': document.cookie.slice(document.cookie.indexOf('JWT=') + 4)
            }
        });

        if (!response.ok) {
            throw new Error('Erreur lors de la validation de l\'opération');
        }

        alert('Opération validée avec succès !');
    } catch (error) {
        alert('Erreur : ' + error.message);
    }
}