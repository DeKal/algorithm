function fileNaming(names) {
  var filenames = {};
  for (name of names) {
    if (name in filenames) {
      var newName = `${name}(${filenames[name]++})`;

      while (newName in filenames) {
        newName = `${name}(${filenames[name]++})`;
      }

      filenames[newName] = 1;
    } else {
      filenames[name] = 1;
    }
  }
  return Object.keys(filenames);
}
