package Funcionalidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Entidades.Usuario;


public class FileReaderTeste {

    public FileReaderTeste() {
    }

    private FileReader data;

    public ArrayList<Usuario> leArquivo(String nomeArquivo) {
        try {
            data = new FileReader(nomeArquivo);
            BufferedWriter arquivo = new BufferedWriter(new FileWriter("Senhas.txt", true));
            arquivo.close();
            BufferedReader linha = new BufferedReader(data);

            ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
            
            String[] vet;

            String aux = linha.readLine();

            while (aux != null) {

                vet = aux.split(",");
                Usuario usuario = new Usuario();

                usuario.setTipo(vet[0]);
                usuario.setSenha(vet[1]);
                usuarios.add(usuario);
                aux = linha.readLine();

            }
             return usuarios;
      
             
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return null;
        
    }

}
