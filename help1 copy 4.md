是的，**Vitest 支持代码覆盖率 (Coverage)**，但默认情况下，它不会自动启用，你需要安装 `c8` 或 `v8-coverage` 作为覆盖率工具。

---

### **如何在 Vitest 启用代码覆盖率？**
#### **方法 1：使用 `c8`（推荐）**
`c8` 是一个轻量级的覆盖率工具，兼容 Vite/Vitest。

#### **步骤：**
1. **安装 `c8`**
   ```sh
   npm install -D c8
   ```

2. **在 `vitest.config.ts` 配置覆盖率**：
   ```ts
   import { defineConfig } from 'vitest/config';

   export default defineConfig({
     test: {
       coverage: {
         provider: 'c8', // 使用 c8 作为覆盖率工具
         reporter: ['text', 'lcov'], // 输出格式，可选 text、lcov、html 等
       },
     },
   });
   ```

3. **运行测试并生成覆盖率报告**：
   ```sh
   npx vitest --coverage
   ```

4. **查看覆盖率报告**
   - 终端会显示覆盖率摘要  
   - 在 `coverage/lcov-report/index.html` 可以查看可视化 HTML 报告  

---

#### **方法 2：使用 `v8`（原生支持，但功能较少）**
Vitest 还支持 **V8 内置覆盖率**，不需要安装 `c8`，但功能较少。

#### **步骤：**
1. **修改 `vitest.config.ts`**：
   ```ts
   import { defineConfig } from 'vitest/config';

   export default defineConfig({
     test: {
       coverage: {
         provider: 'v8', // 使用 V8 内置覆盖率
         reporter: ['text', 'json', 'html'],
       },
     },
   });
   ```

2. **运行覆盖率报告**
   ```sh
   npx vitest --coverage
   ```

---

### **`c8` vs `v8`，选哪个？**
| **工具**  | **优点** | **缺点** |
|-----------|---------|---------|
| `c8` (推荐) | 兼容 Jest，支持 `lcov`、`html` 可视化报告 | 需要额外安装 |
| `v8` | 速度快，无需安装额外依赖 | 报告格式少，不支持 `lcov` |

如果你需要完整的 **HTML 报告、IDE 插件支持 (如 VSCode Jest Coverage)**，**推荐用 `c8`**。  
如果只是简单查看覆盖率数据，**`v8` 也可以**。

---

### **结论**
✅ **Vitest 支持代码覆盖率**  
✅ 推荐使用 `c8`，提供更丰富的报告  
✅ 使用 `v8` 也可以，但功能较少  

你可以根据项目需求选择合适的方案 🚀