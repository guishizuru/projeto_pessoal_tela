package org.example.Sistemas;


@lombok.Data
public class Data {

    private String mesSelecionado;

    public void converterMesDoAnoEmIngles(String mesSelecionado) {

        if (mesSelecionado.equalsIgnoreCase("janeiro")) {
            this.mesSelecionado = "JANUARY";
        } else if (mesSelecionado.equalsIgnoreCase("fevereiro")) {
            this.mesSelecionado = "FEBRUARY";
        } else if (mesSelecionado.equalsIgnoreCase("março")) {
            this.mesSelecionado = "MARCH";
        } else if (mesSelecionado.equalsIgnoreCase("abril")) {
            this.mesSelecionado = "APRIL";
        } else if (mesSelecionado.equalsIgnoreCase("maio")) {
            this.mesSelecionado = "MAY";
        } else if (mesSelecionado.equalsIgnoreCase("junho")) {
            this.mesSelecionado = "JUNE";
        } else if (mesSelecionado.equalsIgnoreCase("julho")) {
            this.mesSelecionado = "JULY";
        } else if (mesSelecionado.equalsIgnoreCase("agosto")) {
            this.mesSelecionado = "AUGUST";
        } else if (mesSelecionado.equalsIgnoreCase("setembro")) {
            this.mesSelecionado = "SEPTEMBER";
        } else if (mesSelecionado.equalsIgnoreCase("outubro")) {
            this.mesSelecionado = "OCTOBER";
        } else if (mesSelecionado.equalsIgnoreCase("novembro")) {
            this.mesSelecionado = "NOVEMBER";
        } else if (mesSelecionado.equalsIgnoreCase("dezembro")) {
            this.mesSelecionado = "DECEMBER";
        }

        //  JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
    }
}
