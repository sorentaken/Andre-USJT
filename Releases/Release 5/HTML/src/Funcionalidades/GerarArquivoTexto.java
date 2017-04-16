package Funcionalidades;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GerarArquivoTexto
{
   private Formatter saida;
   
   public void abrirArquivo()
   {
      try
      {
         saida = new Formatter( "Senhas.txt" );
      }
      catch ( SecurityException excecao )
      {
         System.err.println(
            "Você não tem permissão de gravação para este arquivo." );
         System.exit( 1 );
      } 
      catch ( FileNotFoundException excecao )
      {
         System.err.println( "Erro ao criar arquivo." );
         System.exit( 1 );
      }
   }
   
   public void adicionarRegistros(String a, String b , String c , String d) throws IOException
   { 

      Scanner entrada = new Scanner( System.in );
         try
         {
        	 saida.format("%s%s%s%s" , a,b,c,d);
               
         }
         catch ( FormatterClosedException excecao )
         {
            System.err.println( "Erro ao gravar arquivo." );
            return;
         }
         
         catch ( NoSuchElementException excecao )
         {
            System.err.println( "Entrada inválida. Por favor, tente de novo." );
            entrada.nextLine();
         } 
         
   }
      
   public void fecharArquivo()
   {
      if ( saida != null )
         saida.close();
   }
}
