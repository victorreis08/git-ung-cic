<?php
$rsLista = listarRegistros($vConn, $tabela);
$numCampos=  mysqli_num_fields($rsLista);
$rsCampos = listarCampos($vConn, $tabela);

while($campos = mysqli_fetch_array($rsCampos)){
    $nomeCampos[] = $campos[0];
}

?>

<h5><?=strtoupper($tabela);?></h5>
<hr>
<table class="table-sm table-striped">

    <thead class="table-dark">
        <tr>
        <?php 
        
        $cont = 0;
        foreach($nomeCampos as $valor){ 
            if($cont < 10){
        ?>
            <th><?=$valor;?></th>
        <?php 
            } //fechando if
        $cont++;
        } //fechando for
        ?>
        </tr>
    </thead>
    
    <tbody>
        <?php
        while ($dadosLista = mysqli_fetch_array($rsLista)) {
        ?>   
        <tr>
            <?php 
            for($i=0; $i<$numCampos; $i++){ 
                if ($i < 10){
            ?>
            
            <td><font class="TextoDados"><?=$dadosLista[$i];?></font></td>            
            
            <?php
                } //fechando if
            } //fechando for
            ?>
            
        </tr>

        <?php
        }
        ?>
    </tbody>
    
</table>


