
angular.module('beneficioApp', [])
.controller('BeneficioController', function($scope, $http) {
    const urlBase = '/api/beneficios'; 
    $scope.beneficios = [];
    $scope.carregando = false;

    $scope.carregarBeneficios = function() {
        $scope.carregando = true;
        $http.get(urlBase)
            .then(function(response) {
                $scope.beneficios = response.data;
            })
            .catch(function(error) {
                console.error('Erro ao buscar dados', error);
                alert('Erro ao conectar com o servidor.');
            })
            .finally(function() {
                $scope.carregando = false;
        });
    };

    // transferir Beneficio  
     $scope.trasnferirBeneficio = function() {

        var valorSelecionado = [];       
        var idSelecionados = [];
               
        if ($scope.beneficios.some(b => b.selecionado)){

            angular.forEach($scope.beneficios, function(b) {
                if (b.selecionado) { 
                    idSelecionados.push(b.id); 
                    valorSelecionado.push(b.valor);
                }
            });

            if (idSelecionados.length === 2) {
                var idOrigem = idSelecionados[0];
                var idDestino = idSelecionados[1];
                var valorOrigem = valorSelecionado[0];
                var valorDestino = valorSelecionado[1];
                $http.post(urlBase+ '/' + idOrigem +"/transferir/"+
                idDestino+"/"+ valorDestino);                
                $scope.carregarBeneficios();    
            }else {
                alert("Selecione exatamente 2 benefícios para realizar a transferência.");
            }      
        } else {            
            $scope.limpar();
            $scope.carregarBeneficios();
        }       
    };

    // Salvar (CRIAR ou ATUALIZAR)    
    // Se tem ID, atualiza (PUT) se não tem ID, cria novo (POST)
    $scope.salvar = function() {
        if ($scope.beneficio.id) {
            $http.put(urlBase + '/' + $scope.beneficio.id, $scope.beneficio).then(() => {
                $scope.limpar();
                $scope.carregarBeneficios();
            });
        } else {            
            $http.post(urlBase, $scope.beneficio).then(() => {
                $scope.limpar();
                $scope.carregarBeneficios();
            });
        }
    };

    //Alerta para excluir Beneficio
    $scope.excluir = function(id) {
        if (confirm('Deseja realmente excluir?')) {
            $http.delete(urlBase + '/' + id).then(() => {
                $scope.carregarBeneficios();
            })
            .catch(function(error) {
                console.error("Erro ao excluir:", error);
                alert("Erro no servidor: " + error.data.message);
            });
        }
    };

    // Editar Beneficio
    // Copia para não alterar na tabela antes de salvar
    $scope.editar = function(b) {
        $scope.beneficio = angular.copy(b); 
    };

    //Limpa formulario cadastramento Beneficio
    $scope.limpar = function() {
        $scope.beneficio = { 
            ativo: true,
            nome: '',
            descricao: '',
            valor: 0
        };
    };

    // Carregamento inicial
    $scope.carregarBeneficios();
});