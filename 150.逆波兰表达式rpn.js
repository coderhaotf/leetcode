const isOperator = (s) => ["+", "-", "*", "/"].includes(s);
const parse = (expression) => {
  const tokens = [];
  for (let i = 0; i < expression.length; i++) {
    let token = "";
    if (isOperator(expression[i]) && isOperator(tokens[tokens.length - 1])) {
      token = expression[i];
      i++;
    }
    while (/\d/.test(expression[i])) {
      token = token + expression[i];
      i++;
    }
    if (token) {
      tokens.push(Number(token));
      i--;
    } else {
      if (expression[i] !== " ") {
        tokens.push(expression[i]);
      }
    }
  }
  return tokens;
};

const transform = (tokens) => {
  const operators = [];
  const result = [];
  for (let i = 0; i < tokens.length; i++) {
    const ele = tokens[i];
    if (typeof ele === "number") {
      result.push(ele);
    } else {
      if (ele === "*" || ele === "/" || ele === "(") {
        operators.push(ele);
      } else if (operators[operators.length - 1] === "(") {
        operators.push(ele);
      } else if (ele === ")") {
        while (operators[operators.length - 1] !== "(") {
          result.push(operators.pop());
        }
        operators.pop();
      } else {
        while (operators.length > 0) {
          result.push(operators.pop());
        }
        operators.push(ele);
      }
    }
  }
  while (operators.length > 0) {
    result.push(operators.pop());
  }
  return result;
};

const calc = (tokens) => {
  let stack = [];
  for (let i = 0; i < tokens.length; i++) {
    const ele = tokens[i];
    if (typeof ele === "number") {
      stack.push(ele);
    } else {
      const right = stack.pop();
      const left = stack.pop();
      switch (ele) {
        case "+":
          stack.push(left + right);
          break;
        case "-":
          stack.push(left - right);
          break;
        case "*":
          stack.push(left * right);
          break;
        case "/":
          stack.push(left / right);
          break;
      }
    }
  }
  return stack[0];
};
const rpn = (expression) => {
  const tokens = parse(expression);
  const result = transform(tokens);
  const value = calc(result);
  console.log(value);
  return value;
};

rpn("12 + (7 - 3) * 2 + 9 / 3");

rpn("((10 * (6 * ((9 + 3) * 11))) + 17) + 50");

rpn("2 + 30 * (20 - 10) / (100 / 5)");
