package challenge;

public class CriptografiaCesariana implements Criptografia {

    private static final int COD_ASCII_A_MIN = 97;
    private static final int COD_ASCII_Z_MIN = 122;

    @Override
    public String criptografar(String texto) {
        if (texto == null) {
            throw new NullPointerException("Texto não pode ser nulo");
        }
        if (texto.trim().isEmpty()) {
            throw new IllegalArgumentException("Texto não pode ser vazio");
        }
        StringBuilder novoTexto = new StringBuilder();
        texto.toLowerCase().chars().forEach((charCod) -> this.criptografarChar(charCod, novoTexto, true));
        return novoTexto.toString();
    }

    private void criptografarChar(int codigoChar, StringBuilder sBuilder, boolean isCriptografar) {
        sBuilder.append(this.incrementaCodigo(codigoChar, (isCriptografar ? 3 : -3)));
    }

    private char incrementaCodigo(int codigo, int incremento) {
        if (codigo < COD_ASCII_A_MIN || codigo > COD_ASCII_Z_MIN) {
            return (char) codigo;
        } else {
            int retorno = codigo + incremento;
            if (retorno < COD_ASCII_A_MIN) {
                retorno = COD_ASCII_Z_MIN - (COD_ASCII_A_MIN - retorno + 1);
            } else if (retorno > COD_ASCII_Z_MIN) {
                retorno = COD_ASCII_A_MIN + (retorno - COD_ASCII_Z_MIN + 1);
            }
            return (char) retorno;
        }
    }

    @Override
    public String descriptografar(String texto) {
        if (texto == null) {
            throw new NullPointerException("Texto não pode ser nulo");
        }
        if (texto.trim().isEmpty()) {
            throw new IllegalArgumentException("Texto não pode ser vazio");
        }
        StringBuilder novoTexto = new StringBuilder();
        texto.toLowerCase().chars().forEach((charCod) -> this.criptografarChar(charCod, novoTexto, false));
        return novoTexto.toString();
    }
}
