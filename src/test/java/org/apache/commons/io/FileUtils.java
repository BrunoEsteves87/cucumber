package org.apache.commons.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {

    public static void copyFile(File src, File destino) {
        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(destino)) {

            byte[] buffer = new byte[1024]; // Define o tamanho do buffer
            int length;
            
            // Lê do arquivo de origem e escreve no arquivo de destino
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            
            System.out.println("Arquivo copiado com sucesso para: " + destino.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Erro ao copiar o arquivo: " + e.getMessage());
        }
    }
}

