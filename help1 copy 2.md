是的，在 **Vitest** 中，你可以**排除 Vue 模板 (`template`) 代码的覆盖率计算**，只统计 **TypeScript (`<script setup>`) 逻辑代码**。  

---

### **如何排除 Vue 模板 (`template`) 代码的覆盖率？**

Vitest 使用 `c8` 或 `v8` 进行覆盖率统计，而 **Vue 模板代码在编译后会转换成 `render` 函数**，默认也会算入覆盖率。因此，你可以**通过 `c8` 的 `exclude` 规则，忽略 Vue 组件的模板部分**。

---

### **方法 1：使用 `c8` + `exclude` 规则（推荐）**
**步骤：**
1. **安装 `c8`（如果还没安装）**
   ```sh
   npm install -D c8
   ```

2. **配置 `vitest.config.ts`**
   ```ts
   import { defineConfig } from 'vitest/config';

   export default defineConfig({
     test: {
       coverage: {
         provider: 'c8', // 使用 c8 作为覆盖率工具
         reporter: ['text', 'lcov', 'html'],
         exclude: [
           'src/**/*.vue' // 忽略 Vue 组件文件，避免统计 template 部分
         ],
         include: [
           'src/**/*.ts', // 只统计 TypeScript 逻辑代码
           'src/**/*.js'
         ],
       },
     },
   });
   ```

3. **运行测试覆盖率**
   ```sh
   npx vitest --coverage
   ```

📌 **解释：**  
- `exclude: ['src/**/*.vue']`：排除所有 Vue 组件文件，不统计模板代码的覆盖率。  
- `include: ['src/**/*.ts', 'src/**/*.js']`：只统计 TypeScript 和 JavaScript 代码。  
- 这种方式会**完全忽略 Vue 组件的覆盖率**，适用于只关心 TypeScript 逻辑代码的情况。

---

### **方法 2：只统计 `<script>` 代码，排除 `<template>`**
如果你仍想统计 **Vue 组件的 `<script setup>` 代码**，但**排除 `<template>` 代码**，你需要一个更精细的方式。

#### **步骤：**
1. **配置 `vitest.config.ts`**
   ```ts
   import { defineConfig } from 'vitest/config';

   export default defineConfig({
     test: {
       coverage: {
         provider: 'c8',
         reporter: ['text', 'lcov', 'html'],
         exclude: [
           '**/node_modules/**',
           '**/dist/**',
         ],
         all: true, // 统计所有文件
         extension: ['.ts', '.js', '.vue'], // 确保 Vue 文件的 `<script>` 代码也被统计
         excludeAfterRemap: true, // 避免模板代码影响覆盖率
       },
     },
   });
   ```

2. **运行测试**
   ```sh
   npx vitest --coverage
   ```

📌 **解释：**
- `extension: ['.ts', '.js', '.vue']` 让 c8 解析 Vue 组件的 **`<script setup>` 代码**，但不会统计 `<template>` 代码的影响。  
- `excludeAfterRemap: true` 避免 Vue **模板编译后的 `render` 函数** 影响覆盖率统计。  

**这种方式适用于**：  
✅ **仍然统计 `<script setup>` 代码，但忽略 `<template>` 代码**。

---

### **方法 3：使用 `v8`（适用于小型项目）**
如果你用 `v8` 而不是 `c8`，可以通过 `exclude` 规则排除 Vue 模板：

```ts
import { defineConfig } from 'vitest/config';

export default defineConfig({
  test: {
    coverage: {
      provider: 'v8',
      reporter: ['text', 'json', 'html'],
      exclude: ['src/**/*.vue'], // 排除 Vue 组件，避免统计模板
    },
  },
});
```

但 **`v8` 不如 `c8` 灵活，无法精确控制** 仅排除 `<template>`，因此**推荐 `c8` 方案**。

---

### **最终结论**
| 方案 | 统计 `<script>` 代码 | 忽略 `<template>` 代码 | 适用场景 |
|------|----------------|----------------|------------------|
| **方法 1：c8 + `exclude: ['src/**/*.vue']`** | ❌ 不统计 Vue 组件 | ✅ 忽略 `<template>` | 只关心 TypeScript 代码，不关心 Vue 组件 |
| **方法 2：c8 + `extension: ['.ts', '.js', '.vue']`** | ✅ 统计 `<script setup>` | ✅ 忽略 `<template>` | 统计 Vue 逻辑代码，但不影响模板 |
| **方法 3：v8 + `exclude: ['src/**/*.vue']`** | ❌ 不统计 Vue 组件 | ✅ 忽略 `<template>` | 适用于小型项目，灵活度低 |

🚀 **推荐方案：方法 2**  
👉 **既能统计 Vue `<script>` 代码，又能排除 `<template>` 代码，保持覆盖率精准！**