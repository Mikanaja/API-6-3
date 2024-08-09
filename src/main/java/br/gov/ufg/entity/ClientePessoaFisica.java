package br.gov.ufg.entity;

import java.util.Date;

public class ClientePessoaFisica extends Cliente {
    private String cpf;
    private String rg;
    private Date dataNascimento;

    public boolean validarCPF(String cpf) {
        if (cpf == null || cpf.length() != 11 || cpf.matches(cpf.charAt(0) + "{11}")) {
            return false;
        }
        try {
            int d1 = 0, d2 = 0;
            for (int i = 0; i < 9; i++) {
                int digito = Integer.parseInt(cpf.substring(i, i + 1));
                d1 += (10 - i) * digito;
                d2 += (11 - i) * digito;
            }
            d1 = 11 - (d1 % 11);
            if (d1 >= 10) d1 = 0;
            d2 += 2 * d1;
            d2 = 11 - (d2 % 11);
            if (d2 >= 10) d2 = 0;

            return d1 == Integer.parseInt(cpf.substring(9, 10)) && d2 == Integer.parseInt(cpf.substring(10, 11));
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Getters e Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}