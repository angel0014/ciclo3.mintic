package mintic.cicloiii.reto3;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="custome")

public class Custome implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String brand;
    private Integer year;
    private Integer description;
    private String name;
    

    @ManyToOne
    @JoinColumn(name="idCategory")
    @JsonIgnoreProperties("customes")
    private Categoria category;

    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="custome")
    @JsonIgnoreProperties({"custome", "client"})
    private List<Mensaje> messages;

    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="custome")
    @JsonIgnoreProperties({"custome", "client"})
    private List<Reservacion> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getDescription() {
        return description;
    }

    public void setDescription(Integer description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }

    public List<Mensaje> getMessages() {
        return messages;
    }

    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    public List<Reservacion> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservacion> reservations) {
        this.reservations = reservations;
    }
    



   

}
   

    

