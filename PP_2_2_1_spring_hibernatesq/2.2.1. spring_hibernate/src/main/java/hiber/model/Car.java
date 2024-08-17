package hiber.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {
    @Column(name = "model")
    private String model;
    @Column(name = "series")
    private int series;
    @Basic
    private String car_id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;



    @OneToOne(mappedBy = "car")
    private   User user;
    public Car(User user) {
        this.user = user;
    }
    public Car() {

    }

    public  Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public void setUser(User user1) {
    }
    @Override
    public String toString() {
        return
                "model: " + model + '\'' +
                        " series: "+
                        series
                ;
    }
}

