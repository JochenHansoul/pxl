<?php

declare(strict_types=1);

namespace controller;

use model\StaffPDO;

class StaffController
{
    public function index(): array
    {
        // retrieving data
        $rows = [];
        try {
            $staffPdo = new StaffPDO();
            $rows = $staffPdo->getStaff();
        } catch (\PDOException $e) {
            echo "Staff controller Eexception: " . $e->getMessage();
        }
        return $rows;
    }
}
