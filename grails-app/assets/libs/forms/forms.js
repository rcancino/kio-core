//= require jquery
//= require_self
//= require_tree

$("input[data-moneda]").autoNumeric({wEmpty:'zero',mRound:'B',aSign: '$'});
$("input[data-porcentaje]").autoNumeric({altDec: '%', vMax: '99.99'});