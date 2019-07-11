package br.edu.ifpb.domain.hotel;

import java.io.Serializable;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/07/2019, 10:16:53
 */
public class HospedagemChave implements Serializable{

    private int hotelId;
    private int hospedeId;

    public HospedagemChave() {
    }

    public HospedagemChave(int hotelId,int hospedeId) {
        this.hotelId = hotelId;
        this.hospedeId = hospedeId;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.hotelId;
        hash = 29 * hash + this.hospedeId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HospedagemChave other = (HospedagemChave) obj;
        if (this.hotelId != other.hotelId) {
            return false;
        }
        if (this.hospedeId != other.hospedeId) {
            return false;
        }
        return true;
    }
    
}
