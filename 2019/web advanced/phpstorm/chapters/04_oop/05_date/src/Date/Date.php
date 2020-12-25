<?php

namespace Date;

class Date
{
    public const MONTHS = ["jan", "feb", "mar", "apr", "mei", "jun", "jul", "aug", "sep", "okt", "now", "dec"];
    private const DAYS_IN_MONTHS = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 30];
    private int $year;
    private int $month;
    private int $day;

    /*
     * @throws DateException if the month or day are outside the range of possibilities
     */
    private function __construct(int $year, int $month, int $day)
    {
        if ($month < 1 || $month > 12) {
            throw new DateException("wrong input of month");
        }
        if (
            $day < 1
            || $day > self::DAYS_IN_MONTHS[$month -1]
            || ($day === 29 && $month === 2 && ($year % 4 !== 0 || $year % 100 === 0 && $year % 400 !== 0))
        ) {
            throw new DateException("Wrong input of day");
        }
        $this->year = $year;
        $this->month = $month;
        $this->day = $day;
    }

    public static function make(int $year = 2008, int $month = 1, int $day = 1): Date
    {
//        $date = null;
//        try {
//            $date = new self($day, $month, $year);
//        } catch (DateException $e) {
//            throw new DateException("Error in static function Date::make", 0, $e);
//        }
        return new self($year, $month, $day); // anders zegt dat error nooit word getrowt in het catch block van de app
    }

    public function changeDay(int $day): Date
    {
        //return new self(self::getYear(), self::getMonth(), $day);
        return new $this($this::getYear(), $this::getMonth(), $day);
    }

    public function changeMonth(int $month): Date
    {
        return new $this($this::getYear(), $month, $this::getDay());
    }

    public function changeYear(int $year): Date
    {
        return new $this($year, $this::getMonth(), $this::getDay());
    }

    // getters
    public function getDay(): int
    {
        return $this->day;
    }

    public function getMonth(): int
    {
        return $this->month;
    }

    public function getYear(): int
    {
        return $this->year;
    }

    public function print(): void
    {
        echo "{$this->day}/{$this->month}/{$this->year}";
    }

    public function printMonth(): void
    {
        //echo "{$this->day}/" . self::MONTHS[$this->month -1] . "/{$this->year}"; // works off course
        //echo "{$this->day}/self::MONTHS[$this->month -1]/{$this->year}"; // prints: .../self::MONTHS[ nr - 1]/...
        //echo "{$this->day}/{self::MONTHS[$this->month -1]}/{$this->year}"; // prints: .../{self::MONTHS[ nr - 1]}/...
        //echo "{$this->day}/$this::MONTHS[$this->month - 1]/{$this->year}"; // throws error
        echo "{$this->day}/{$this::MONTHS[$this->month - 1]}/{$this->year}"; // works
    }
}
