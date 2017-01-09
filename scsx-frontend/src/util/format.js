export function formatSalary(floor, ceil) {
    floor = Number(floor)
    ceil = Number(ceil)
    if (floor >= 1000) {
        return Math.floor(floor / 1000) + 'K - ' + Math.floor(ceil / 1000) + 'K'
    } else {
        return floor + ' - ' + ceil
    }
}
