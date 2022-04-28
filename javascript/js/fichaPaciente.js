let planoDeSaudeCbx = document.getElementById('Plano_de_saude');
let nomePlano = document.getElementById('NomePlano'); 
planoDeSaudeCbx.checked = false;

function showInput(){
  if (planoDeSaudeCbx.checked == true){
    console.log('Checado')
    nomePlano.style.display = "block";
  }else if(planoDeSaudeCbx.checked == false){
    nomePlano.style.display = "none";
  }
}
