/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sFJPA;
import jakarta.persistence.*;

/**
 *
 * @author d4cd13ger
 */


@Entity
@NamedQueries(
    {
        @NamedQuery(name = "Owners.getAllOwner", query = "SELECT p FROM Proprietaire p"),
        @NamedQuery(name = "Owners.getOwnerById", query = "SELECT p FROM Proprietaire p WHERE p.id = :id"),
        @NamedQuery(name = "Owners.deleteOwnerById", query = "DELETE FROM Proprietaire p WHERE p.id = :id")
    }
)
@Table(name = "Proprietaire")
public class Proprietaire extends Utilisateur{
    
}
