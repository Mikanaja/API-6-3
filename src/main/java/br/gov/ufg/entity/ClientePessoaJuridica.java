package br.gov.ufg.entity;

public class ClientePessoaJuridica extends Cliente {
    private String cnpj;
    private String razaoSocial;
    private String inscricaoEstadual;

    public boolean validarCNPJ(String cnpj) {
        if (cnpj == null || cnpj.length() != 14 || cnpj.matches(cnpj.charAt(0) + "{14}")) {
            return false;
        }
        try {
            int[] multiplicadores1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
            int[] multiplicadores2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

            int d1 = 0, d2 = 0;
            for (int i = 0; i < 12; i++) {
                int digito = Integer.parseInt(cnpj.substring(i, i + 1));
                d1 += multiplicadores1[i] * digito;
                d2 += multiplicadores2[i] * digito;
            }
            d1 = d1 % 11 < 2 ? 0 : 11 - (d1 % 11);
            d2 += 2 * d1;
            d2 = d2 % 11 < 2 ? 0 : 11 - (d2 % 11);

            return d1 == Integer.parseInt(cnpj.substring(12, 13)) && d2 == Integer.parseInt(cnpj.substring(13, 14));
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Getters e Setters
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }
}