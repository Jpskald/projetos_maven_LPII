package aula_bd;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class aluno {
    private String nome;

    public static void main(String[] args) {
        aluno a = new aluno();
        a.setNome("Maria");

        System.out.println(a);
    }

}
