package br.edu.ifpb.domain;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 07/06/2019, 08:38:35
 */
@Entity
public class Perfil implements Serializable {

    @Id
    private int codigo;
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private String descricao; // C-LOB
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private byte[] foto; // B-LOB

    public Perfil() {
    }

    public Perfil(int codigo,String descricao,String path) {
        this.codigo = codigo;
        this.descricao = descricao;
        try {
            this.foto = new ImageFromFile(
                path
            ).toBytes();
        } catch (IOException ex) {
            this.foto = new byte[0];
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

}
