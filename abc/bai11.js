function ResetData(obj) {
    return Array.isArray(obj) ? obj.map(ResetData)
      : typeof obj === 'object' && obj !== null ? Object.fromEntries(
          Object.entries(obj).map(([key, value]) => [key, ResetData(value)])
        )
      : typeof obj === 'string' ? ''
      : typeof obj === 'number' ? 0
      : typeof obj === 'boolean' ? false
      : obj;
  }
  
  const obj = {
    name: "trung",
    age: 18,
    isStatus: true,
    a: {
      a: [1, 2, 3],
      b: {
        c: 2
      }
    },
    c: ['a', 'b', 'c']
  };
  
  console.log(ResetData(obj));
  