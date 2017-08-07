if (!String.format) {
  String.format = function(format) {
    var args = Array.prototype.slice.call(arguments, 1);
    return format.replace(/{(\d+)}/g, function(match, number) { 
      return typeof args[number] !== undefined
        ? args[number] 
        : match
      ;
    });
  };
}

// if (!String.prototype.format) {
//   String.prototype.format = function() {
//     var args = arguments;
//     return this.replace(/{(\d+)}/g, function(match, number) { 
//       return typeof args[number] !== undefined
//         ? args[number]
//         : match
//       ;
//     });
//   };
// }