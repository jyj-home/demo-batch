在 **Jest** 中，默认使用 **CommonJS (CJS)**，但如果你需要 **手动启用 ESM (ECMAScript Modules)**，可以按照以下步骤操作。  

---

## **方法 1：使用 `jest` 原生 ESM 支持**
### **步骤 1：安装 `jest` 和 `babel-jest`**
```sh
npm install --save-dev jest babel-jest @babel/preset-env
```

### **步骤 2：配置 `package.json`**
在 `package.json` 中，添加 `"type": "module"`，让 Node.js 以 ESM 模式运行：
```json
{
  "type": "module",
  "jest": {
    "transform": {}
  }
}
```
📌 **注意**：  
- **Jest 28+ 版本** 开始，已经**实验性**支持 **ESM**，但默认不启用 `babel-jest`，所以需要手动配置 `transform: {}`，否则 Jest 仍然会当作 CommonJS 运行。

---

### **步骤 3：配置 `.babelrc`**
如果你需要 Babel 来编译 ES 模块，创建 **`.babelrc`**：
```json
{
  "presets": ["@babel/preset-env"]
}
```

---

### **步骤 4：运行测试**
```sh
npx jest
```
或
```sh
npm test
```

🚀 **这样 Jest 就能支持 ESM 了！**

---

## **方法 2：使用 `jest-esm-transformer`（适用于复杂项目）**
如果你的项目遇到 **Jest 的 ESM 兼容性问题**，可以使用 **`jest-esm-transformer`**：

### **步骤 1：安装 `jest-esm-transformer`**
```sh
npm install --save-dev jest-esm-transformer
```

### **步骤 2：修改 `jest.config.js`**
```js
export default {
  transform: {
    "^.+\\.js$": "jest-esm-transformer"
  },
};
```
📌 **这样，Jest 会正确解析 ESM 代码，而不会报 `SyntaxError: Cannot use import statement outside a module`**。

---

## **方法 3：使用 `node --experimental-vm-modules` 运行 Jest**
如果你不想改动 `jest.config.js`，可以直接运行：
```sh
node --experimental-vm-modules node_modules/.bin/jest
```
或者：
```sh
NODE_OPTIONS="--experimental-vm-modules" jest
```
这会让 Node.js 以 **实验性 ESM 模式** 运行 Jest。

---

## **总结**
| 方案 | 适用场景 | 兼容性 |
|------|--------|------|
| **方法 1：Jest 原生 ESM** | 适用于大多数项目 | ✅ 官方支持，但仍在实验阶段 |
| **方法 2：`jest-esm-transformer`** | 适用于复杂项目或 Babel 转译 | ✅ 兼容性较好 |
| **方法 3：`--experimental-vm-modules`** | 适用于临时测试 | ⚠ 可能不稳定 |

🚀 **最佳方案**：  
如果你的项目是 **纯 ESM**，推荐 **方法 1**（官方支持）。  
如果有 **复杂的 Babel 配置**，可以使用 **方法 2**。