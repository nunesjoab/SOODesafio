/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo;

import static Utils.ReadSheet.ReadSheet;
import java.util.Scanner;

/**
 *
 * @author Phones
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        System.out.println("Entre com o nome ou caminho do arquivo");
        Scanner in =new Scanner(System.in);
        String arquivo = in.nextLine();
        ReadSheet(arquivo);
    }
}
