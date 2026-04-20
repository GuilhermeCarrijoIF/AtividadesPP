public final class Notebook {

    private final String processador;
    private final String memoriaRAM;
    private final String armazenamento;
    private final String placaDeVideo;
    private final String sistemaOperacional;

    private Notebook(Builder builder) {
        this.processador = builder.processador;
        this.memoriaRAM = builder.memoriaRAM;
        this.armazenamento = builder.armazenamento;
        this.placaDeVideo = builder.placaDeVideo;
        this.sistemaOperacional = builder.sistemaOperacional;
    }

    public String getProcessador() {
        return processador;
    }

    public String getMemoriaRAM() {
        return memoriaRAM;
    }

    public String getArmazenamento() {
        return armazenamento;
    }

    public String getPlacaDeVideo() {
        return placaDeVideo;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    @Override
    public String toString() {
        return "Notebook {" +
                "\n  Processador: " + processador +
                "\n  Memória RAM: " + memoriaRAM +
                "\n  Armazenamento: " + armazenamento +
                "\n  Placa de Vídeo: " + placaDeVideo +
                "\n  Sistema Operacional: " + sistemaOperacional +
                "\n}";
    }

    public static class Builder {
        private final String processador;
        private final String memoriaRAM;
        private final String armazenamento;
        private String placaDeVideo;
        private String sistemaOperacional;

        public Builder(String processador, String memoriaRAM, String armazenamento) {
            if (processador == null || processador.isBlank()) {
                throw new IllegalArgumentException("Processador não pode ser vazio.");
            }
            if (memoriaRAM == null || memoriaRAM.isBlank()) {
                throw new IllegalArgumentException("Memória RAM não pode ser vazia.");
            }
            if (armazenamento == null || armazenamento.isBlank()) {
                throw new IllegalArgumentException("Armazenamento não pode ser vazio.");
            }

            this.processador = processador;
            this.memoriaRAM = memoriaRAM;
            this.armazenamento = armazenamento;
        }

        public Builder comPlacaDeVideo(String placaDeVideo) {
            if (placaDeVideo == null || placaDeVideo.isBlank()) {
                throw new IllegalArgumentException("Placa de vídeo não pode ser vazia.");
            }
            this.placaDeVideo = placaDeVideo;
            return this;
        }

        public Builder comSistemaOperacional(String sistemaOperacional) {
            if (sistemaOperacional == null || sistemaOperacional.isBlank()) {
                throw new IllegalArgumentException("Sistema Operacional não pode ser vazio.");
            }
            this.sistemaOperacional = sistemaOperacional;
            return this;
        }

        public Notebook build() {
            if (placaDeVideo == null || placaDeVideo.isBlank()) {
                throw new IllegalStateException("Placa de vídeo é obrigatória.");
            }
            if (sistemaOperacional == null || sistemaOperacional.isBlank()) {
                throw new IllegalStateException("Sistema Operacional é obrigatório.");
            }
            return new Notebook(this);
        }
    }
}