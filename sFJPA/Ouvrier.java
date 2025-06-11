/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sFJPA;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author d4cd13ger
 */


@Entity
@NamedQueries(
    {
        @NamedQuery(name = "Workers.getAllWorkers", query = "SELECT o FROM Ouvrier o"),
        @NamedQuery(name = "Workers.getWorkersById", query = "SELECT o FROM Ouvrier o WHERE o.id = :id"),        
        @NamedQuery(name = "Workers.deleteWorkerById", query = "DELETE FROM Ouvrier o WHERE o.id = :id")
    }
)
@Table(name = "Ouvrier")
public class Ouvrier extends Utilisateur implements Serializable {
    
}
