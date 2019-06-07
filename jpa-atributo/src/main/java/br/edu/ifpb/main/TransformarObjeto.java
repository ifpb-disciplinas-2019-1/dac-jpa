package br.edu.ifpb.main;

import br.edu.ifpb.domain.Aluno;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 07/06/2019, 08:28:33
 */
public class TransformarObjeto {
    public static void main(String[] args) {
        XStream xstream = new XStream(new DomDriver());
        String xml = xstream.toXML(
            new Aluno(1,"123","Maria",7)
        );
        System.out.println(xml);
    }
}
