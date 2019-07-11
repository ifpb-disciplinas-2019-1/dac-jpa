package br.edu.ifpb.domain.hotel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/07/2019, 09:56:25
 */
@Entity
@IdClass(HospedagemChave.class)
public class Hospedagem implements Serializable {

    @Id
    @Column(name = "hotel_id",updatable = false,insertable = false)
    private int hotelId; //be specified read-only
    @Column(name = "hospede_id",updatable = false,insertable = false)
    @Id
    private int hospedeId;//be specified read-only

    @ManyToOne
    private Hotel hotel;
    @ManyToOne
    private Hospede hospede;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    public Hospedagem() {
    }

    public Hospedagem(
        Hotel hotel,
        Hospede hospede,
        Date data) {
        this.hotel = hotel;
        this.hospede = hospede;
        this.data = data;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getHospedeId() {
        return hospedeId;
    }

    public void setHospedeId(int hospedeId) {
        this.hospedeId = hospedeId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
