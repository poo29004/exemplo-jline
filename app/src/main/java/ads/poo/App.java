package ads.poo;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;

public class App {

    public static void main(String[] args) throws Exception {

        // Cria um terminal usando JLine
        Terminal terminal = TerminalBuilder.builder().dumb(true).build();

        // Classe AttributedString para manipular texto com estilo (cores, negrito, etc)
        AttributedString texto;
        
        int coresPorLinha = 16;
        int larguarDaMascara = 4;

        String titulo = "..:: Veja abaixo as 256 cores ANSI ::..";
        
        int largura = ((coresPorLinha * larguarDaMascara) - titulo.length()) / 2;

        terminal.writer().println();
        
        // imprimindo espaços em branco para deixar o título centralizado
        terminal.writer().print(" ".repeat(largura));

        texto = new AttributedString(String.format("%s", titulo),
                AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW).bold());
                
        
        terminal.writer().println(texto.toAnsi()+"\n");


        for (int i = 0; i < 256; i += coresPorLinha) {
            for (int j = 0; j < coresPorLinha; j++) {
                
                int cor = i + j;

                texto = new AttributedString(String.format("%4d", cor),
                        AttributedStyle.DEFAULT.foreground(cor));

                terminal.writer().print(texto.toAnsi());
            }
            // Pula para a próxima linha
            terminal.writer().println();
        }
        // Descarrega o conteúdo do buffer do terminal e exibe na tela
        terminal.flush();
    }
}
