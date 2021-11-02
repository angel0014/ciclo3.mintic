package mintic.cicloiii.reto3;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Costume")

public class Costume implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(length=4)
    private Integer id;

    @Column(length=45)
    private String name;

    @Column(length=45)
    private String brand;

    @Column(length=4)
    private Integer year;

    @Column(length=250)
    private String description;

   
    
    @ManyToOne
    @JoinColumn(name="idCategory")
    @JsonIgnoreProperties("costumes")
    private Categoria category;

    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="costume")
    @JsonIgnoreProperties({"costume", "client"})
    private List<Mensaje> messages;

    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="costume")
    @JsonIgnoreProperties({"costume", "client"})
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
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
   

    

