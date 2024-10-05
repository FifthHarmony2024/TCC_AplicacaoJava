package br.com.etechoracio.aplicacaoTcc.entity;

import br.com.etechoracio.aplicacaoTcc.repository.CategoriaRepository;
import br.com.etechoracio.aplicacaoTcc.repository.ServicoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader {

    @Bean
    CommandLineRunner loadData(CategoriaRepository categoriaRepository, ServicoRepository servicoRepository) {
        return args -> {
            var assistenciaTecnica = new Categoria(null, "Assistência Técnica", null, null);
            var aulas = new Categoria(null, "Aulas", null, null);
            var reformasReparos = new Categoria(null, "Reformas e Reparos", null, null);
            var servicosDomesticos = new Categoria(null, "Serviços Domésticos", null, null);
            var eventos = new Categoria(null, "Eventos", null, null);
            var saude = new Categoria(null, "Saúde", null, null);
            var servicosGerais = new Categoria(null, "Serviços Gerais", null, null);
            var transporte = new Categoria(null, "Transporte", null, null);

            categoriaRepository.saveAll(Arrays.asList(assistenciaTecnica, aulas, reformasReparos, servicosDomesticos, eventos,saude,  servicosGerais,transporte ));

            servicoRepository.saveAll(Arrays.asList(
                    new Servico(null, "Televisão", "Conserto de Televisão", null, assistenciaTecnica),
                    new Servico(null, "Ar Condicionado", "Instalação de Ar Condicionado", null, assistenciaTecnica),
                    new Servico(null, "Aparelho de Som", "Conserto de Aparelho de Som", null, assistenciaTecnica),
                    new Servico(null, "DVD / Blu-Ray", "Conserto de DVD / Blu-Ray", null, assistenciaTecnica),
                    new Servico(null, "Home theater", "Conserto de Home theater", null, assistenciaTecnica),
                    new Servico(null, "Vídeo Game", "Conserto de Vídeo Game", null, assistenciaTecnica),
                    new Servico(null, "Câmera", "Conserto de Câmera", null, assistenciaTecnica),
                    new Servico(null, "Aquecedor a Gás", "Conserto de Aquecedor a Gás", null, assistenciaTecnica),
                    new Servico(null, "Conserto/Instalação de Lava Roupa", "Conserto e Instalação de Lava Roupa", null, assistenciaTecnica),
                    new Servico(null, "Conserto/Instalação de Geladeira e freezer", "Conserto e Instalação de Geladeira e Freezer", null, assistenciaTecnica),
                    new Servico(null, "Conserto/Instalação de Fogão e cooktop", "Conserto e Instalação de Fogão e Cooktop", null, assistenciaTecnica),
                    new Servico(null, "Conserto/Instalação de Micro-ondas", "Conserto e Instalação de Micro-ondas", null, assistenciaTecnica),
                    new Servico(null, "Conserto/Instalação de Lava-Louça", "Conserto e Instalação de Lava-Louça", null, assistenciaTecnica),
                    new Servico(null, "Conserto/Instalação de Máquina de Costura", "Conserto e Instalação de Máquina de Costura", null, assistenciaTecnica),
                    new Servico(null, "Conserto/Instalação de Adega Climatizada", "Conserto e Instalação de Adega Climatizada", null, assistenciaTecnica),
                    new Servico(null, "Conserto/Instalação de Secadora de Roupas", "Conserto e Instalação de Secadora de Roupas", null, assistenciaTecnica),
                    new Servico(null, "Conserto/Instalação de Cabeamento de Redes", "Conserto e Instalação de Cabeamento de Redes", null, assistenciaTecnica),

                    // Aulas
                    new Servico(null, "Idiomas", "Aulas de Idiomas", null, aulas),
                    new Servico(null, "Escolares e Reforço", "Aulas Escolares e Reforço", null, aulas),
                    new Servico(null, "Concursos", "Aulas para Concursos", null, aulas),
                    new Servico(null, "Pré-Vestibular", "Aulas de Pré-Vestibular", null, aulas),
                    new Servico(null, "Ensino Superior", "Aulas de Ensino Superior", null, aulas),
                    new Servico(null, "Educação Especial", "Aulas de Educação Especial", null, aulas),
                    new Servico(null, "Ensino Profissionalizante", "Ensino Profissionalizante", null, aulas),
                    new Servico(null, "Saúde", "Aulas na Área de Saúde", null, aulas),
                    new Servico(null, "Tarefas", "Apoio em Tarefas Escolares", null, aulas),
                    new Servico(null, "Música", "Aulas de Música", null, aulas),
                    new Servico(null, "Artes", "Aulas de Artes", null, aulas),
                    new Servico(null, "Bem-Estar", "Aulas de Bem-Estar", null, aulas),
                    new Servico(null, "Artesanato", "Aulas de Artesanato", null, aulas),
                    new Servico(null, "TV e Teatro", "Aulas de TV e Teatro", null, aulas),
                    new Servico(null, "Circo", "Aulas de Circo", null, aulas),
                    new Servico(null, "Beleza", "Aulas de Beleza", null, aulas),
                    new Servico(null, "Paisagismo", "Aulas de Paisagismo", null, aulas),
                    new Servico(null, "Moda", "Aulas de Moda", null, aulas),
                    new Servico(null, "Fotografia", "Aulas de Fotografia", null, aulas),
                    new Servico(null, "Esportes", "Aulas de Esportes", null, aulas),
                    new Servico(null, "Dança", "Aulas de Dança", null, aulas),
                    new Servico(null, "Luta", "Aulas de Luta", null, aulas),
                    new Servico(null, "Lazer", "Aulas de Lazer", null, aulas),
                    new Servico(null, "Jogos", "Aulas de Jogos", null, aulas),
                    new Servico(null, "Informática", "Aulas de Informática", null, aulas),
                    new Servico(null, "Esportes Eletrônicos", "Aulas de Esportes Eletrônicos", null, aulas),
                    new Servico(null, "Desenvolvimento Web", "Aulas de Desenvolvimento Web", null, aulas),
                    new Servico(null, "Marketing Digital", "Aulas de Marketing Digital", null, aulas),

                    new Servico(null, "Aluguel de Maquinário", "Aluguel de Maquinário para Obras", null, reformasReparos),
                    new Servico(null, "Pedreiro", "Reparos em Alvenaria", null, reformasReparos),
                    new Servico(null, "Arquiteto", "Serviços de Arquitetura", null, reformasReparos),
                    new Servico(null, "Limpeza Pós Obra", "Limpeza após Obras", null, reformasReparos),
                    new Servico(null, "Engenheiro", "Serviços de Engenharia", null, reformasReparos),
                    new Servico(null, "Marmoraria e Granitos", "Serviços de Marmoraria e Granitos", null, reformasReparos),
                    new Servico(null, "Poço Artesiano", "Perfuração de Poço Artesiano", null, reformasReparos),
                    new Servico(null, "Remoção de Entulho", "Serviço de Remoção de Entulho", null, reformasReparos),
                    new Servico(null, "Empreiteiro", "Serviços de Empreiteiro", null, reformasReparos),
                    new Servico(null, "Design de Interiores", "Serviços de Design de Interiores", null, reformasReparos),
                    new Servico(null, "Segurança Eletrônica", "Instalação de Segurança Eletrônica", null, reformasReparos),
                    new Servico(null, "Automação Residencial", "Automação Residencial", null, reformasReparos),
                    new Servico(null, "Antenista", "Serviço de Antenista", null, reformasReparos),
                    new Servico(null, "Toldos e Coberturas", "Instalação de Toldos e Coberturas", null, reformasReparos),
                    new Servico(null, "Decorador", "Serviços de Decoração", null, reformasReparos),
                    new Servico(null, "Montador de Móveis", "Montagem de Móveis", null, reformasReparos),
                    new Servico(null, "Paisagista", "Serviços de Paisagismo", null, reformasReparos),
                    new Servico(null, "Jardinagem", "Serviços de Jardinagem", null, reformasReparos),
                    new Servico(null, "Piscina", "Instalação e Manutenção de Piscinas", null, reformasReparos),
                    new Servico(null, "Redes de Proteção", "Instalação de Redes de Proteção", null, reformasReparos),
                    new Servico(null, "Coifas e Exaustores", "Instalação de Coifas e Exaustores", null, reformasReparos),
                    new Servico(null, "Instalação de Papel de Parede", "Instalação de Papel de Parede", null, reformasReparos),
                    new Servico(null, "Banheira", "Instalação de Banheira", null, reformasReparos),
                    new Servico(null, "Eletricista", "Serviços de Eletricista", null, reformasReparos),
                    new Servico(null, "Gesso e DryWall", "Instalação de Gesso e DryWall", null, reformasReparos),
                    new Servico(null, "Pintor", "Serviços de Pintor", null, reformasReparos),
                    new Servico(null, "Vidraceiro", "Serviços de Vidraceiro", null, reformasReparos),
                    new Servico(null, "Serralheiria e Solda", "Serviços de Serralheiria e Solda", null, reformasReparos),
                    new Servico(null, "Encanador", "Serviços de Encanador", null, reformasReparos),
                    new Servico(null, "Gás", "Instalação e Manutenção de Gás", null, reformasReparos),
                    new Servico(null, "Pavimentação", "Serviços de Pavimentação", null, reformasReparos),
                    new Servico(null, "Dedetizador", "Serviços de Dedetização", null, reformasReparos),
                    new Servico(null, "Desentupidor", "Serviços de Desentupimento", null, reformasReparos),
                    new Servico(null, "Marceneiro", "Serviços de Marceneiro", null, reformasReparos),
                    new Servico(null, "Marido de Aluguel", "Serviços de Marido de Aluguel", null, reformasReparos),
                    new Servico(null, "Chaveiro", "Serviços de Chaveiro", null, reformasReparos),
                    new Servico(null, "Mudanças e Carretos", "Serviços de Mudanças e Carretos", null, reformasReparos),
                    new Servico(null, "Tapeceiro", "Serviços de Tapeçaria", null, reformasReparos),
                    new Servico(null, "Impermeabilizador", "Serviços de Impermeabilização", null, reformasReparos),
                    new Servico(null, "Desinfecção", "Serviços de Desinfecção", null, reformasReparos),

                    new Servico(null, "Diarista", "Serviços de Diarista", null, servicosDomesticos),
                    new Servico(null, "Limpeza de Piscina", "Serviços de Limpeza de Piscina", null, servicosDomesticos),
                    new Servico(null, "Passadeira", "Serviços de Passadeira", null, servicosDomesticos),
                    new Servico(null, "Personal Shopper", "Serviços de Personal Shopper", null, servicosDomesticos),
                    new Servico(null, "Lavadeira", "Serviços de Lavadeira", null, servicosDomesticos),
                    new Servico(null, "Babá", "Serviços de Babá", null, servicosDomesticos),
                    new Servico(null, "Cozinheira", "Serviços de Cozinheira", null, servicosDomesticos),
                    new Servico(null, "Motorista", "Serviços de Motorista", null, servicosDomesticos),
                    new Servico(null, "Personal Organizer", "Serviços de Personal Organizer", null, servicosDomesticos),
                    new Servico(null, "Entregador", "Serviços de Entregador", null, servicosDomesticos),
                    new Servico(null, "Segurança Particular", "Serviços de Segurança Particular", null, servicosDomesticos),
                    new Servico(null, "Adestrador de Cães", "Serviços de Adestrador de Cães", null, servicosDomesticos),
                    new Servico(null, "Passeador de Cães", "Serviços de Passeador de Cães", null, servicosDomesticos),
                    new Servico(null, "Serviços para Pets em geral", "Serviços Gerais para Pets", null, servicosDomesticos),


                    new Servico(null, "Buffet Completo", "Serviços de Buffet Completo", null, eventos),
                    new Servico(null, "Churrasqueiro", "Serviços de Churrasqueiro", null, eventos),
                    new Servico(null, "Bartenders", "Serviços de Bartender", null, eventos),
                    new Servico(null, "Confeiteira", "Serviços de Confeitaria", null, eventos),
                    new Servico(null, "Chocolateiro", "Serviços de Chocolateiro", null, eventos),
                    new Servico(null, "Recepcionistas e Cerimonialistas", "Serviços de Recepcionistas e Cerimonialistas", null, eventos),
                    new Servico(null, "Equipamentos para Festas", "Aluguel de Equipamentos para Festas", null, eventos),
                    new Servico(null, "Garçons e Copeiras", "Serviços de Garçons e Copeiras", null, eventos),
                    new Servico(null, "Segurança", "Serviços de Segurança para Eventos", null, eventos),
                    new Servico(null, "Celebrantes", "Serviços de Celebrantes", null, eventos),
                    new Servico(null, "Manobristas", "Serviços de Manobrista", null, eventos),
                    new Servico(null, "Organização de Eventos", "Serviços de Organização de Eventos", null, eventos),
                    new Servico(null, "Bandas e Cantores", "Serviços de Bandas e Cantores", null, eventos),
                    new Servico(null, "Animação de Festas", "Serviços de Animação de Festas", null, eventos),
                    new Servico(null, "Djs", "Serviços de Djs", null, eventos),
                    new Servico(null, "Gravação de Vídeos", "Serviços de Gravação de Vídeos", null, eventos),
                    new Servico(null, "Fotografia", "Serviços de Fotografia", null, eventos),
                    new Servico(null, "Floristas", "Serviços de Floristas", null, eventos),
                    new Servico(null, "Brindes e Lembrancinhas", "Serviços de Brindes e Lembrancinhas", null, eventos),

                    new Servico(null, "Cuidador de Pessoas", "Serviços de Cuidador de Pessoas", null, saude),
                    new Servico(null, "Enfermeira", "Serviços de Enfermagem", null, saude),
                    new Servico(null, "Psicólogo", "Serviços de Psicologia", null, saude),
                    new Servico(null, "Psicanalista", "Serviços de Psicanálise", null, saude),
                    new Servico(null, "Coach", "Serviços de Coach", null, saude),
                    new Servico(null, "Doula", "Serviços de Doula", null, saude),
                    new Servico(null, "Aconselhamento Conjugal e Familiar", "Serviços de Aconselhamento Conjugal e Familiar", null, saude),
                    new Servico(null, "Fisioterapeuta", "Serviços de Fisioterapia", null, saude)
           ));
        };
    }
}
