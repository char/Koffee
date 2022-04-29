package codes.som.koffee.labels

public interface LabelScope {
    /**
     * This is a short name used to easily create and reference labels:
     * ```kt
     * // ...
     * +L["foo"]
     * // ...
     * goto(L["foo"])
     * ```
     */
    public val L: LabelRegistry
}
