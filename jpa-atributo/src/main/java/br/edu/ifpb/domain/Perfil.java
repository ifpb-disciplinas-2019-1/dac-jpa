package br.edu.ifpb.domain;

import java.io.Serializable;
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
    @Basic(fetch = FetchType.EAGER)
    @Lob
    private byte[] foto; // B-LOB
    @Transient
    private ImageFromFile image;

    public Perfil() {
    }

    public Perfil(int codigo, String descricao, String path) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.image = new ImageFromFile(path);
        this.foto = this.image.toBytes();
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
