package br.edu.ifpb.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 07/06/2019, 08:53:24
 */
public class ImageFromFile {

    private final Path path;

    public ImageFromFile(String path) {
        this(
                Paths.get(path)
        );
    }

    public ImageFromFile(Path path) {
        this.path = path;
    }

    public byte[] toBytes() {
        try {
            return Files.readAllBytes(path);
        } catch (IOException ex) {
            return new byte[0];
        }
    }

    // TODO: método que transforma byte[] em File
    // public File toFile() {}
}
