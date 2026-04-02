package br.com.boleiroOn.domain.arrematacao.service;


import br.com.boleiroOn.domain.arrematacao.dto.ArrematacaoRequestDto;
import br.com.boleiroOn.domain.arrematacao.entity.ArrematacaoEntity;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.io.ByteArrayOutputStream;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class PdfGeradorService {

    private final SpringTemplateEngine templateEngine;

    public byte[] gerarAutoArrematacaoPdf(ArrematacaoEntity arrematacao, String fotoBase64Completa) throws Exception {

        Context context = new Context();

        // 1. Formatadores para deixar o PDF com cara de documento oficial
        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        NumberFormat formatadorMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        // 2. Dados da Arrematação
        String dataFormatada = arrematacao.getDataArrematacao() != null
                ? arrematacao.getDataArrematacao().format(formatadorData)
                : "";
        context.setVariable("dataLeilao", dataFormatada);
        context.setVariable("valorArremate", formatadorMoeda.format(arrematacao.getValorArrematacao()));

        // Como você usa @PrePersist/@PreUpdate para calcular a comissão, ela já deve estar na entidade
        context.setVariable("valorComissao", arrematacao.getValorComissao() != null
                ? formatadorMoeda.format(arrematacao.getValorComissao())
                : "R$ 0,00");

        // 3. Dados do Lote (Navegando pelo relacionamento)
        if (arrematacao.getLote() != null) {
            // Ajuste o '.getId()' ou '.getNumero()' de acordo com o nome do atributo na sua LoteEntity
            context.setVariable("numeroLote", arrematacao.getLote().getId());
        }

        // 4. Dados do Arrematante (Navegando pelo relacionamento)
        if (arrematacao.getArrematante() != null) {
            // Ajuste os getters de acordo com os atributos reais da sua ArrematanteEntity
            context.setVariable("nomeArrematante", arrematacao.getArrematante().getNome());
            context.setVariable("placa", arrematacao.getArrematante().getPlaca());
            context.setVariable("telefone", arrematacao.getArrematante().getTelefone());
        } else {
            context.setVariable("nomeArrematante", "Não Informado");
        }

        // 5. A foto em Base64 para a assinatura
        context.setVariable("fotoAssinaturaBase64", fotoBase64Completa);

        // Processa o HTML
        String htmlProcessado = templateEngine.process("auto-arrematacao", context);

        // Gera o PDF
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.withHtmlContent(htmlProcessado, "");
            builder.toStream(outputStream);
            builder.run();

            return outputStream.toByteArray();
        }
    }
}
